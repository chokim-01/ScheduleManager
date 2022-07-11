package com.web.backend.notification.sse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDto {

    private String content;

    private String url;

}
