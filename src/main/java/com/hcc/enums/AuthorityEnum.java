package com.hcc.enums;

public enum AuthorityEnum {
    ROLE_STUDENT,
    ROLE_ADMIN,
    ROLE_REVIEWER;

    public static AuthorityEnum fromRole(String role) {
        for (AuthorityEnum authority : AuthorityEnum.values()) {
            if (authority.name().equals(role)) {
                return authority;
            }
        }
        return null;
    }
}
