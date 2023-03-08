package ex.proj.skyline.saitonproject.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Vladislav Domaniewski
 */

@Entity
@Table
@EqualsAndHashCode(of = {"id"})
@JsonAutoDetect
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.idName.class)
    private Long id;
    @JsonView(Views.idName.class)
    private String name;
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.fullNote.class)
    private LocalDateTime creationDateTime;
}
