package com.example.leadmanagement.contract;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponseDetails {

	 private String code;
     private List<String> messages;

     public ErrorResponseDetails(String code, List<String> messages) {
         this.code = code;
         this.messages = messages;
     }
 
}
