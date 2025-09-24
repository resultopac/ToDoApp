import os


def getPrompt():
    try:
        current_dir = os.path.dirname(os.path.abspath(__file__))
        prompts_dir = os.path.join(os.path.dirname(current_dir), 'prompts')
        prompt_file = os.path.join(prompts_dir, 'CreateSprintPrompt.txt')

        with open(prompt_file, 'r', encoding='utf-8') as f:
            return f.read()
    except Exception as e:
        print(f"Prompt dosyası okuma hatası: {e}")
        return 'Fiş metnini düzenle ve yapılandır.'


