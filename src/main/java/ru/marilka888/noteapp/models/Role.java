package ru.marilka888.noteapp.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER;

    @Override
    public String getAuthority() {//возвращает роли в строковом виде
        return name();
    }
}
