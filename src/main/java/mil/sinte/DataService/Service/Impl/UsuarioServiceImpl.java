package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuario;
import mil.sinte.DataService.DAO.UsuarioDAO;
import mil.sinte.DataService.Service.UsuarioService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public BeanUsuario findByUsername(String usuario) {
        return usuarioDAO.findByUsuario(usuario);
    }

    @Override
    public BeanUsuario findByUsernameAndEstado(String usuario, String estado) {
        return usuarioDAO.findByUsuarioAndEstado(usuario, estado);
    }

    @Override
    public List<BeanUsuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public String guardarUsuario(BeanUsuario objBeanUsuario, String opciones, String usuario, String modo) {
        String result = "GUARDO";
        try {
            usuarioDAO.sp_usuario(
                    objBeanUsuario.getUsuario(),
                    Utiles.encriptarPassword(objBeanUsuario.getUsuario()),
                    objBeanUsuario.getBrigada() != null ? Integer.parseInt(objBeanUsuario.getBrigada()) : null,
                    objBeanUsuario.getPaterno(),
                    objBeanUsuario.getMaterno(),
                    objBeanUsuario.getNombres(),
                    objBeanUsuario.getAreaLaboral() != null ? Integer.parseInt(objBeanUsuario.getAreaLaboral()) : null,
                    objBeanUsuario.getCargo(),
                    objBeanUsuario.getTelefono(),
                    objBeanUsuario.getCorreo(),
                    objBeanUsuario.getRol() != null ? Integer.parseInt(objBeanUsuario.getRol()) : null,
                    objBeanUsuario.getAutorizacion(),
                    opciones,
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
