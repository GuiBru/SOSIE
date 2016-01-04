package messages.models;

import utils.socket.IMessage;

public class EuSubjectsRequest implements IMessage {
    private final int euId;

    public EuSubjectsRequest(int euId) {
        this.euId = euId;
    }

    public int getEuId() {
        return euId;
    }

}