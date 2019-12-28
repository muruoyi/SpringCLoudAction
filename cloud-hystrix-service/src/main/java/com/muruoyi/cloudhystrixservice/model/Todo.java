package com.muruoyi.cloudhystrixservice.model;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class Todo {
    private Integer id;
    private String title;

    private String desc;

}
