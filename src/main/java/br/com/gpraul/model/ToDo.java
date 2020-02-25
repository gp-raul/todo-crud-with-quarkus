package br.com.gpraul.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "priority", nullable = false)
    private Priority priority;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ToDo() {}

    public ToDo(final Builder builder) {
        this.uuid = builder.uuid;
        this.title = builder.title;
        this.body = builder.body;
        this.completed = builder.completed;
        this.priority = builder.priority;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class Builder {

        private String uuid;

        private final String title;

        private final String body;

        private boolean completed;

        private Priority priority = Priority.LOW;

        private LocalDateTime createdAt = LocalDateTime.now();

        private LocalDateTime updatedAt = LocalDateTime.now();

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

        public Builder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ToDo build() {
            return new ToDo(this);
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", isCompleted=" + completed +
                ", priority=" + priority +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
