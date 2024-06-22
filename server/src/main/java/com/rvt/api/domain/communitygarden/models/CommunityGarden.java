package com.rvt.api.domain.communitygarden.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rvt.api.domain.communitygarden.dtos.CreateCommunityGardenData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document("community_garden")
public class CommunityGarden {
  private String id;
  private String name;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String about;
  private String instructions;
  
  @Field(name = "opening_hours")
  @JsonProperty("opening_hours")
  private String openingHours;  
  
  @Field(name = "open_on_weekends")
  @JsonProperty("open_on_weekends")
  private Boolean openOnWeekends = false;
  
  private List<Image> images;

  public CommunityGarden(CreateCommunityGardenData data, List<Image> images) {
    this.name = data.getName();
    this.latitude = data.getLatitude();
    this.longitude = data.getLongitude();
    this.about = data.getAbout();
    this.instructions = data.getInstructions();
    this.openingHours = data.getOpening_hours();
    this.openOnWeekends = data.getOpen_on_weekends();
    this.images = images;
  }
}
