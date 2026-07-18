package com.soft_universe.tranneer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RefreshToken {
    private Long id;
    private String token;
    private LocalDateTime expiryDate;

    @ManyToOne
    private User user;
}
