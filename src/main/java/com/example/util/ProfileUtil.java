package com.example.util;

import com.example.dto.BaseDTO;
import com.example.dto.ScheduleDTO;
import com.example.entity.ScheduleEntity;
import com.example.exp.AppBadRequestException;

public class ProfileUtil {
    public static void check(BaseDTO dto) {
        checkingName(dto.getName());
        checkingSurname(dto.getSurname());
        checkingPhone(dto.getPhone());
        if (dto.getAge() < 18){
            throw new AppBadRequestException("18 yoshdan katta bo'lishi kerak");
        }
    }

    public static void checkingName(String value){
        if (value.length() < 3 || value.isBlank()){
            throw new AppBadRequestException("There are not enough characters");
        }
        isCapital(value);
        char[] arr = value.toCharArray();
        for (char c : arr) {
            if (c > 32 && c < 58) {
                throw new AppBadRequestException("There is an excess character");
            }
        }
    }

    public static void checkingSurname(String value){
        if (value.length() < 2 || value.isBlank()){
            throw new AppBadRequestException("There are not enough characters");
        }
        isCapital(value);
        char[] arr = value.toCharArray();
        for (char c : arr) {
            if (c > 32 && c < 58) {
                throw new AppBadRequestException("There is an excess character");
            }
        }
    }

    public static void checkingPhone(String phone){
        boolean bool = true;
        char[] arr = phone.toCharArray();

        if (phone.length() != 13 || !phone.startsWith("+998")){
            bool = false;
        }

        for (int i = 1; i< arr.length; i++) {
            if (arr[i] < 48 || arr[i] > 57) {
                bool = false;
                break;
            }
        }
        if (!bool){
            throw new AppBadRequestException("Phone not valid");
        }
    }

    public static void isCapital(String value){
        if (value.charAt(0) < 64 || value.charAt(0) > 91) {
            throw new AppBadRequestException("Note the capital letter");
        }
    }




}
