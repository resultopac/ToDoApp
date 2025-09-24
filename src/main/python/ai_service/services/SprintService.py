from utils.FileUtils import getPrompt
from utils.ModelUtils import CreateSprintByLLM


def CreateSprint(sprintInfo, userContent,existedTasks):
    result = CreateSprintByLLM(sprintInfo, userContent, existedTasks,getPrompt())
    return result


