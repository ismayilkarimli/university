package com.university.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToMany(mappedBy = "lectures", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"lectures"})
    @ToString.Exclude
    private Set<Student> students;

    @ManyToOne
    @JoinTable(name = "LECTURE_INSTRUCTOR",
    joinColumns = @JoinColumn(name = "lecture_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "instructor_id", nullable = false))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"lectures"})
    @ToString.Exclude
    private Instructor instructor;

    @ManyToOne
    @JoinTable(name = "LECTURE_CLASSROOM",
    joinColumns = @JoinColumn(name = "lecture_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "classroom_id", nullable = false))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"lectures"})
    @ToString.Exclude
    private Classroom classroom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        return id != null ? id.equals(lecture.id) : lecture.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
