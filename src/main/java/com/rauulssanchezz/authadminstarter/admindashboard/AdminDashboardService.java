package com.rauulssanchezz.authadminstarter.admindashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rauulssanchezz.authadminstarter.user.UserService;

@Service
public class AdminDashboardService {

    @Autowired
    private UserService userService;
    
    // Aqui se añaden los repositorios: NoteRepository, etc.

    public List<AdminDashboardItemDto> getDashboardWidgets() {
        List<AdminDashboardItemDto> widgets = new ArrayList<>();

        // Registro de Usuarios
        widgets.add(
            new AdminDashboardItemDto(
                "Users", userService.getCount(),
                "bi-people",
                "/admin/users"
            )
        );

        // Cuando añadas algo nuevo como Notas, solo vienes aquí y pones:
        // widgets.add(new DashboardItemDto("Notas", noteRepository.count(), "bi-journal", "/admin/notes"));

        return widgets;
    }
}
