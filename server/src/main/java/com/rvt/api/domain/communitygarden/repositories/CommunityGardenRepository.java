package com.rvt.api.domain.communitygarden.repositories;

import com.rvt.api.domain.communitygarden.models.CommunityGarden;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityGardenRepository extends MongoRepository<CommunityGarden, String> { }
