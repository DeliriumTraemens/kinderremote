package org.nick.kinderremote.data.entity.authorithy;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "oc_sessionnew")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "sessionId")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sessionId;

    @Column(name="uuid")
    private String uuid;


    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_added")
    private LocalDateTime creationDate;

    @Column(name ="visited")
    private boolean visited=false;

//    @Column(name ="customer_id")
//    private Long customerId;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    private Customer customer;

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", uuid='" + uuid + '\'' +
                ", creationDate=" + creationDate +
                ", visited=" + visited +
                '}';
    }
}
