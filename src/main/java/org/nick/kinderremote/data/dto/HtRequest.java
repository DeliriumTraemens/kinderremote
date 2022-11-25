package org.nick.kinderremote.data.dto;

import lombok.Data;

@Data
public class HtRequest {
    private String serviceName;
    private String methodName;
    private Long сatId;
    private Long prodId;
    private Long manId;
    private String searchName;
    private int requestedPage;
    private int totalPages;
}
