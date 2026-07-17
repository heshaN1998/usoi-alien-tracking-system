package com.soft_universe.tranneer.security;

import com.soft_universe.tranneer.util.SecurityUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component("auditorAware")
public class AuditorAwareIMPL  implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityUtil.getCurrentUsername()
        );

    }
}
