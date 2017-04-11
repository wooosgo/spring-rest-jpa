package hello;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jonas on 05/04/2017.
 */

public interface    ScheduleRepository extends JpaRepository<Schedule,Long> {
}

