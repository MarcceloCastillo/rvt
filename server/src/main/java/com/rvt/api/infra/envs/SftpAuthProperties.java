package com.rvt.api.infra.envs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "sftp")
public class SftpAuthProperties {
  private String host;
  private Integer port;
  private String username;
  private String password;
  private String directory;
}
