package ru.itpark.milkyKitchen.models;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sec_user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sec_user_id_gen")
    @SequenceGenerator(name = "sec_user_id_gen",sequenceName = "public.sec_user_seq",allocationSize = 1)
    private Integer id;
    private String login;

    @Column(name = "password")
    private String password;

    @Column
    private boolean blocked;
}
