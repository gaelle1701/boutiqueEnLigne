package com.boutiqueEnLigne.fngcine.mail;
import com.boutiqueEnLigne.fngcine.entity.Order;

import java.util.Map;

public interface EmailService {
    void sendSimpleMessage(Order order);
}
