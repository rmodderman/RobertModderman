package com.ilionx.pianoapp.persistence;

import com.ilionx.pianoapp.model.Piano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PianoRepository extends JpaRepository<Piano, Long> {

}
