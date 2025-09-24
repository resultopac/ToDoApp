import json
import os
import re
import google.generativeai as genai
from dotenv import load_dotenv


load_dotenv()

GEMINI_API_KEY = os.getenv("GEMINI_API_KEY")
GEMINI_MODEL = os.getenv("GEMINI_MODEL", "gemini-2.0-flash-lite")

if GEMINI_API_KEY:
    genai.configure(api_key=GEMINI_API_KEY)
    model = genai.GenerativeModel(GEMINI_MODEL)
else:
    model = None


def extract_json_from_text(text: str):
    fenced = re.search(r"```(?:json)?\s*(\{[\s\S]*\})\s*```", text)
    if fenced:
        candidate = fenced.group(1)
    else:
        brace_start = text.find("{")
        brace_end = text.rfind("}")
        candidate = text[brace_start:brace_end + 1] if brace_start != -1 and brace_end != -1 else text
    try:
        return json.loads(candidate)
    except Exception:
        cleaned = re.sub(r",(\s*[}\]])", r"\1", candidate)
        return json.loads(cleaned)


def CreateSprintByLLM(sprintInfo, userContent,existedTasks, systemPrompt):
    try:
        if model is None:
            raise RuntimeError("GEMINI_API_KEY bulunamadı. Lütfen ortam değişkenini ayarlayın.")
        full_prompt = f"{systemPrompt}\n\n{sprintInfo}\n\n{userContent}\n\n{existedTasks}"
        response = model.generate_content(full_prompt)
        result = response.text.strip()
        json_data = extract_json_from_text(result)
        return json_data
    except Exception as e:
        return {"error": f"API Hatası: {str(e)}"}


