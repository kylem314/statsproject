package com.nighthawk.intellijs.SQL;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /*
    @NonNull: Places this in @RequiredArgsConstructor
    @Size(min=2, max=30): Allows names between 2 and 30 characters long.
     */
    @NonNull
    @Size(min = 2, message = "College Name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    /* Initializer used when setting data from an API */
    public College(String name, Date deadline) {
        this.name = name;
        this.deadline = deadline;

    }



}