package br.com.gpraul.dto;

import br.com.gpraul.model.Priority;

import java.io.Serializable;

public class ToDoDto implements Serializable {

    private String uuid;

    private  String title;

    private String body;

    private boolean completed;

    private Priority priority;

    public ToDoDto() {}

    public ToDoDto(final Builder builder) {
        this.uuid = builder.uuid;
        this.title = builder.title;
        this.body = builder.body;
        this.completed = builder.completed;
        this.priority = builder.priority;
    }

    public static class Builder {

        private String uuid;

        private final String title;

        private final String body;

        private boolean completed;

        private Priority priority;

        public Builder(final String title, final String body) {
            this.title = title;
            this.body = body;
        }

        public Builder uuid(final String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder isCompleted(final boolean completed) {
            this.completed = completed;
            return this;
        }

        public Builder priority(final Priority priority) {
            this.priority = priority;
            return this;
        }

        public ToDoDto build() {
            return new ToDoDto(this);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ToDoDto{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }
}
