package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    //  권한 반환하기
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    // 사용자의 id를 반환(고유한 값)
    @Override
    public String getUsername(){
        return email;
    }

    // 사용자의 password를 반환
    @Override
    public String getPassword(){
        return password;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired(){
        return true; //: 계정 만료 확인 로직(true-만료X)
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked(){
        return true; //: 계정 잠금 여부 확인 로직(true-잠금X)
    }

    // 비밀번호 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired(){
        return true; //: 비밀번호 만료 여부 확인 로직(true-유효)
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled(){
        return true; //: 계정 사용 가능 여부 확인 로직(true-사용가능)
    }

}
