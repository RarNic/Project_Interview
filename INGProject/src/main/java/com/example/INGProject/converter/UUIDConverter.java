package com.example.INGProject.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

@Mapper
public interface UUIDConverter {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ConvertUUIDToString {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ConvertStringToUUID {
    }

    @ConvertUUIDToString
    public static String convertUUIDToString(UUID uuid) {
        return uuid != null ? uuid.toString() : null;
    }

    @ConvertStringToUUID
    public static UUID convertStringToUUID(String uuidString) {
        return uuidString != null ? UUID.fromString(uuidString) : null;
    }
}
