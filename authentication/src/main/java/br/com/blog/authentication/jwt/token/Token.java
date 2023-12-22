package br.com.blog.authentication.jwt.token;

import br.com.blog.authentication.auth.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "token")
@Table(name = "tokens")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String token;

    @Enumerated
    public TokenType tokenType = TokenType.BEARER;
    public boolean revoked;
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

}