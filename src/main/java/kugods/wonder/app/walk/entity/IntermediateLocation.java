package kugods.wonder.app.walk.entity;

import kugods.wonder.app.common.entity.BaseEntity;
import kugods.wonder.app.walk.dto.IntermediateLocationResponse;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "IntermediateLocation")
@Entity
public class IntermediateLocation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intermediateLocationId;

    @Column(precision = 18, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(precision = 18, scale = 10, nullable = false)
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "walk_id")
    private Walk walk;

    public IntermediateLocationResponse toResponse() {
        return IntermediateLocationResponse.builder()
                .intermediateLocationId(intermediateLocationId)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
