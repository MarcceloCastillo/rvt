package com.rvt.api.domain.communitygarden.services;

import com.rvt.api.domain.communitygarden.dtos.CreateCommunityGardenData;
import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.models.File;
import com.rvt.api.domain.communitygarden.models.Image;
import com.rvt.api.domain.communitygarden.models.CommunityGarden;
import com.rvt.api.domain.communitygarden.repositories.CommunityGardenRepository;
import com.rvt.api.infra.envs.ImageServerProperties;
import com.rvt.api.utils.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
@AllArgsConstructor
public class CreateCommunityGardenService {
  private final CommunityGardenRepository communityGardenRepository;
  private final UploadImageService uploadService;
  private final ImageServerProperties statics;
  
  public CommunityGardenInfo image(CreateCommunityGardenData data) {
    var files = Lists.fromNullable(data.getImages());    
    var orphanage = communityGardenRepository.save(new CommunityGarden(data, upload(files)));    
    return new CommunityGardenInfo(orphanage, statics);
  }
  
  public List<Image> upload(List<MultipartFile> multipartFiles) {
    try {
      var files = File.from(multipartFiles);      
      uploadService.upload(files);
      return Image.from(files);
    } catch (Exception exception) {
      throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "error on upload images");
    }
  };
}
