package br.com.ListadTarefas.Model;

public class TarefasModel {
    private String id;
    private String nametask;
    private String statusTask;

    public TarefasModel(String id, String nametask, String statusTask) {
        this.id = id;
        this.nametask = nametask;
        this.statusTask = statusTask;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNametask() {
        return nametask;
    }

    public void setNametask(String nametask) {
        this.nametask = nametask;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(String statusTask) {
        this.statusTask = statusTask;
    }
}
