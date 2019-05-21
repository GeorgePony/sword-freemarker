package com.originaltek.freemarker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailFreeEntity {
    private String sender;
    private String receiver;
    private String method;
    private String content;
}
