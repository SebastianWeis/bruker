package de.sweis;

import de.sweis.solver.IsotopeQuerySolver;

import java.util.Arrays;

public class Main {
    public static final String[] isotopes = {"3H", "1H", "19F", "3He", "205Tl", //0-4
            "203Tl", "31P", "7Li", "119Sn", "117Sn", //5-9
            "87Rb", "115Sn", "11B", "125Te", "141Pr", //10-14
            "71Ga", "65Cu", "129Xe", "81Br", "63Cu", //15-19
            "23Na", "51V", "123Te", "27Al", "13C", //20-24
            "79Br", "151Eu", "55Mn", "93Nb", "45Sc", //25-29
            "159Tb", "69Ga", "121Sb", "59Co", "187Re", //30-34
            "185Re", "99Tc", "113Cd", "115In", "113In", //35-39
            "195Pt", "165Ho", "111Cd", "207Pb", "127I", //40-44
            "29Si", "77Se", "199Hg", "171Yb", "75As", //45-49
            "209Bi", "2H", "6Li", "139La", "9Be", //50-55
            "17O", "138La", "133Cs", "123Sb", "181Ta", //55-59
            "175Lu", "137Ba", "153Eu", "10B", "15N", //60-64
            "50V", "135Ba", "35Cl", "85Rb", "91Zr", //65-69
            "61Ni", "169Tm", "131Xe", "37Cl", "176Lu", //70-74
            "21Ne", "189Os", "33S", "14N", "43Ca", //75-79
            "97Mo", "201Hg", "95Mo", "67Zn", "25Mg", //80-84
            "53Cr", "49Ti", "47Ti", "143Nd", "79Se", //85-89
            "101Ru", "89Y", "173Yb", "163Dy", "39K", //90-94
            "109Ag", "99Ru", "105Pd", "87Sr", "147Sm", //95-99
            "183W", "107Ag", "157Gd", "177Hf", "83Kr", //100-104
            "73Ge", "149Sm", "161Dy", "145Nd", "57Fe", //105-109
            "103Rh", "155Gd", "167Er", "41K", "179Hf", //110-114
            "187Os", "193Ir", "235U", "197Au", "191Ir"}; //115-119

    public static void main(String[] args) {
        TerminalQueryApplication app = new TerminalQueryApplication(new IsotopeQuerySolver(Arrays.asList(isotopes)));
        app.run();


    }

}
