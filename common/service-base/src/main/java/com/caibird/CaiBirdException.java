package com.caibird;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaiBirdException extends RuntimeException {

    private Integer code;

    private String msg;

}
