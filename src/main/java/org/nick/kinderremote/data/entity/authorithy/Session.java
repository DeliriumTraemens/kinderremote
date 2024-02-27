package org.nick.kinderremote.data.entity.authorithy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "oc_sessionnew")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SessionId;
    @Column(name="uuid")
    private String uuid;

    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_added")
    private LocalDateTime creationDate;
}
