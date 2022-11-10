package me.ammardev.pluginr;

public class Server {

    public ServerType serverType;
    public String serverName;
    public String version;

    public Server(ServerType serverType, String serverName, String version) {
        this.serverType = serverType;
        this.serverName = serverName;
        this.version = version;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public void setServerType(ServerType serverType) {
        this.serverType = serverType;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
