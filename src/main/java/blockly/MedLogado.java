package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class MedLogado {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// MedLogado
public static Var medLogado() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var UserLogado() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

}

