package com.schoolmanagement.model;

import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {

	private String email;

	private String password;
}
