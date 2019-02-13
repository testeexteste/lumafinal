package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BuscarDados {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// BuscarDados
public static Var ExecutarBuscarDados() throws Exception {
 return new Callable<Var>() {

   private Var consul = Var.VAR_NULL;

   public Var call() throws Exception {
    consul = cronapi.database.Operations.query(Var.valueOf("app.entity.Agenda"),Var.valueOf("select a.medico.user.name, a.horario_Escala.nm_horario_hre, a.local_Plantao.nm_local_lpl, a from Agenda a"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

