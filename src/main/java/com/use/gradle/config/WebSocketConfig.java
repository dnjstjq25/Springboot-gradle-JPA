package com.use.gradle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration //설정
@EnableWebSocketMessageBroker //WebSocket 서버 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
                                        //웹 소켓 연결을 구성하기 위한 메서드를 제공

    //클라이언트가 웹 소켓 서버에 연결하는 데 사용할 엔드포인트 등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //웹 소켓을 지원하지 않는 브라우저에 폴백 옵션을 활성화하기 위해 사용
        // * 폴백 => 어떤 기능이 약해지거나 작동하지 않을 때 대처하는 기능 또는 동작
        registry.addEndpoint("/ws").withSockJS();
    }

    //한 클라이언트 -> 다른 클라이언트로 메세지를 라우팅 하는 데 사용될 메세지 브로커를 구성
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // /app으로 시작되는 메세지가 message-handling methods로 라우팅 되어야 하는 것을 명시
        registry.setApplicationDestinationPrefixes("/app");
        // /topic 으로 시작되는 메세지가 메세지 브로커로 라우팅 되도록 정의
        registry.enableSimpleBroker("/topic");
    }
}
