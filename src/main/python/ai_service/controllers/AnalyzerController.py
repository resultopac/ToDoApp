from fastapi import APIRouter, HTTPException
from fastapi.responses import JSONResponse
from pydantic import BaseModel
from services.SprintService import CreateSprint

# Router oluştur
router = APIRouter(prefix="", tags=["Document Analysis"])


class SprintRequest(BaseModel):
    sprintInfo: str
    userContent: str
    taskInfos : str


@router.post("/api/create-sprint")
async def CreateSprintForFirstTime(request: SprintRequest):
    try:
        return JSONResponse(CreateSprint(request.sprintInfo, request.userContent,request.taskInfos))
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Sprint oluşturma hatası: {str(e)}")


