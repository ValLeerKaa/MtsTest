package MTS.testServer;

public class ServerState {
    private boolean active;
    private boolean paused;
    private boolean clientRestartRequired;

    public boolean isActive() {
        return active;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isClientRestartRequired() {
        return clientRestartRequired;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void setClientRestartRequired(boolean clientRestartRequired) {
        this.clientRestartRequired = clientRestartRequired;
    }
}
