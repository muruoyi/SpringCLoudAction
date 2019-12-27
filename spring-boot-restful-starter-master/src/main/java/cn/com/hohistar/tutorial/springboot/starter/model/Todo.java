package cn.com.hohistar.tutorial.springboot.starter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel(description = "All details about the Todo.")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(notes = "唯一编码，有系统自动生成")
    private Integer id;

    @NotNull
    @ApiModelProperty(notes = "title is required.")
    private String title;

    private String desc;

}
