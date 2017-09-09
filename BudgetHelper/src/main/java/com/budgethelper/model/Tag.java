package com.budgethelper.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tag)) {
            return false;
        }

        final Tag tag = (Tag) o;

        if (this.id != null) {
            return this.id.equals(tag.getId());
        }
        if (title != null ? !title.equals(tag.title) : tag.title != null) return false;
        return createdDate != null ? createdDate.equals(tag.createdDate) : tag.createdDate == null;
    }

    @Override
    public int hashCode() {
        if (this.id != null) {
            return this.id.hashCode();
        }
        int result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", createdDate=" + createdDate +
            ", updatedDate=" + updatedDate +
            '}';
    }
}
