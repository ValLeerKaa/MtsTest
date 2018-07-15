package MTS.testServer;

public class ServerState {
    private boolean active;
    private boolean paused;
    private boolean clientRestartRequired;

    public ServerState getState()
    {
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isClientRestartRequired() {
        return clientRestartRequired;
    }

    public ServerState setActive(boolean active) {
        this.active = active;
        return this;
    }

    public ServerState setPaused(boolean paused) {
        this.paused = paused;
        return this;
    }

    public ServerState setClientRestartRequired(boolean clientRestartRequired) {
        this.clientRestartRequired = clientRestartRequired;
        return this;
    }
}
