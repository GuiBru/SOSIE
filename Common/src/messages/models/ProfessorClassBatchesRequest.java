package messages.models;

import utils.socket.IMessage;

public class ProfessorClassBatchesRequest implements IMessage {
    private final int professorId;

    public ProfessorClassBatchesRequest(int professorId) {
        this.professorId = professorId;
    }

    public int getProfessorId() {
        return this.professorId;
    }
}