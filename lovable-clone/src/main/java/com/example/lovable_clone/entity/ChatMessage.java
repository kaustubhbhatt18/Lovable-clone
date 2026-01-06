package com.example.lovable_clone.entity;

import com.example.lovable_clone.enums.MessageRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    MessageRole messageRole;
    String toolCalls;//Json Array of totals called
    Integer tokensUsed;
    Instant createdAt;
}
