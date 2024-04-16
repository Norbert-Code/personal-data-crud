package com.pdm.repository;

import com.pdm.model.*;
import org.springframework.data.jpa.repository.*;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
