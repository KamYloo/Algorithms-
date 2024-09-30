public class Drzewo {
    public  Wezel rotacja_RR(Wezel w, Wezel A)
    {
        Wezel B = A.lewySyn;
        Wezel ojciecA = A.ojciec;
        A.lewySyn = B.prawySyn;
        if (A.lewySyn != null) A.lewySyn.ojciec = A;

        B.prawySyn = A;
        B.ojciec = ojciecA;
        A.ojciec = B;

        if (ojciecA == null)
            w = B;
        else if (ojciecA.prawySyn == A)
            ojciecA.prawySyn = B;
        else if (ojciecA.lewySyn == A)
            ojciecA.lewySyn = B;


        if (B.waga == 1)
        {
            B.waga = 0;
            A.waga = 0;
        }
        else if (B.waga == 0)
        {
            B.waga = -1;
            A.waga = 1;
        }

        return w;
    }

    public  Wezel rotacja_LL(Wezel w, Wezel A)
    {
        Wezel B = A.prawySyn;
        Wezel ojciecA = A.ojciec;

        A.prawySyn = B.lewySyn;
        if (A.prawySyn != null) A.prawySyn.ojciec = A;

        B.lewySyn = A;
        B.ojciec = ojciecA;
        A.ojciec = B;

        if (ojciecA == null)
            w = B;
        else if (ojciecA.prawySyn == A)
            ojciecA.prawySyn = B;
        else if (ojciecA.lewySyn == A)
            ojciecA.lewySyn = B;


        if (B.waga == -1)
        {
            B.waga = 0;
            A.waga = 0;
        }
        else if (B.waga == 0)
        {
            B.waga = 1;
            A.waga = -1;
        }

        return w;
    }
    public  Wezel rotacja_LR(Wezel w , Wezel A)
    {
        Wezel B = A.lewySyn;
        Wezel C = B.prawySyn;
        Wezel ojciecA = A.ojciec;
        B.prawySyn = C.lewySyn;
        if (B.prawySyn != null) B.prawySyn.ojciec = B;

        A.lewySyn = C.prawySyn;
        if (A.lewySyn != null) A.lewySyn.ojciec = A;

        C.prawySyn = A;
        C.lewySyn = B;
        A.ojciec = C;
        B.ojciec = C;

        C.ojciec = ojciecA;

        if (ojciecA == null)
            w = C;
        else if(ojciecA.prawySyn == A)
            ojciecA.prawySyn = C;
        else if (ojciecA.lewySyn == A)
            ojciecA.lewySyn = C;


        if (C.waga == -1)
        {
            C.waga = 0;
            B.waga = 1;
            A.waga = 0;
        }
        else if (C.waga == 1)
        {
            C.waga = 0;
            B.waga = 0;
            A.waga = -1;
        }
        else if (C.waga == 0)
        {
            C.waga = 0;
            B.waga = 0;
            A.waga = 0;
        }

        return w;
    }
    public  Wezel rotacja_RL(Wezel w,Wezel A)
    {
        Wezel B = A.prawySyn;
        Wezel C = B.lewySyn;
        Wezel ojciecA = A.ojciec;

        B.lewySyn = C.prawySyn;
        if (B.lewySyn != null)
            B.lewySyn.ojciec = B;

        A.prawySyn = C.lewySyn;
        if (A.prawySyn != null)
            A.prawySyn.ojciec = A;

        C.lewySyn = A;
        C.prawySyn = B;
        A.ojciec = C;
        B.ojciec = C;

        C.ojciec = ojciecA;

        if (ojciecA == null)
            w = C;
        else if(ojciecA.prawySyn == A)
            ojciecA.prawySyn = C;
        else if (ojciecA.lewySyn == A)
            ojciecA.lewySyn = C;


        if (C.waga == 1){
            C.waga = 0;
            B.waga = -1;
            A.waga = 0;
        }
        else if (C.waga == 0)
        {
            C.waga = 0;
            B.waga = 0;
            A.waga = 0;
        }
        else if (C.waga == -1)
        {
            C.waga = 0;
            B.waga = 0;
            A.waga = 1;
        }

        return w;
    }

     public Wezel wstaw(Wezel korzen,double liczba)
    {
        Wezel w = new Wezel(liczba);
        Wezel k = korzen;
        if (k == null)
            korzen = w;
        else {
            while (true) {
                if (k.liczba < liczba) {
                    if (k.prawySyn == null) {
                        k.prawySyn = w;
                        break;
                    }
                    k = k.prawySyn;
                } else {
                    if (k.lewySyn == null) {
                        k.lewySyn = w;
                        break;
                    }
                    k = k.lewySyn;
                }
            }
                int x= 0;
                w.ojciec = k;
                Wezel y = w;
                Wezel poprzednik = y.ojciec;
                while (poprzednik != null){

                    if (poprzednik.prawySyn == y)
                        poprzednik.waga--;
                    if (poprzednik.lewySyn == y)
                        poprzednik.waga++;
                    y = poprzednik;
                    poprzednik = poprzednik.ojciec;
                    if (y.waga == 0)
                        break;
                    if (y.waga == 2 || y.waga == -2)
                    {
                       x = 1;
                       break;
                    }
                    }
                if (x == 1)
                {
                    if (y.waga == 2)
                    {
                        if (y.lewySyn.waga == 1 || y.lewySyn.waga == 0)
                            korzen = rotacja_RR(korzen,y);
                        else
                            korzen = rotacja_LR(korzen,y);
                    }
                    else {
                        if (y.prawySyn.waga == -1 || y.prawySyn.waga == 0)
                            korzen = rotacja_LL(korzen,y);
                        else
                            korzen = rotacja_RL(korzen,y);
                    }
                }
                }
        return korzen;
    }
    public  Wezel nast(Wezel p) {
        if (p != null) {
            if (p.prawySyn != null) {
                p = p.prawySyn;
                while (p.lewySyn != null) p = p.lewySyn;
            }
        }
        return p;
    }
    public Wezel usun(Wezel korzen, Wezel x)
    {
        int q=0;
        Wezel y=null, z = null;
        if(x.lewySyn == null || x.prawySyn == null)
            y = x;
        else
            y = nast(x);

        if (y.lewySyn != null)
        {
            z = y.lewySyn;
        }
        else if (y.prawySyn != null)
        {
            z = y.prawySyn;
        }

        if (z != null)
            z.ojciec=y.ojciec;

        Wezel p = y.ojciec;


        if (y.ojciec == null)
        {
            korzen = z;
            if (korzen != null) {
                if (korzen.prawySyn != null)
                    korzen.waga--;
                else if (korzen.lewySyn != null)
                    korzen.waga++;
                else
                    korzen.waga = 0;
                p = korzen;
            }
        }
        else if (y == p.lewySyn)
        {
            p.lewySyn = z;
            p.waga--;
            if (p.waga == -2)
                q = 1;
            else if (p.waga == 0)
                q = 2;
        }
        else
        {
            p.prawySyn = z;
            p.waga++;
            if (p.waga == 2)
                q = 1;
            else if (p.waga == 0)
                q = 2;
        }

        if (y != x)
            x.liczba = y.liczba;


        if (q == 2)
        {
            Wezel poprzednik = p.ojciec;
            while (poprzednik != null)
            {
                if (poprzednik.prawySyn == p)
                    poprzednik.waga++;
                if (poprzednik.lewySyn == p)
                    poprzednik.waga--;
                p = poprzednik;
                poprzednik = poprzednik.ojciec;
                if (p.waga == 1 || p.waga == -1)
                    break;
                if (p.waga == 2 || p.waga == -2)
                {
                    if (p.waga == 2)
                    {
                        if (p.lewySyn.waga == 1 || p.lewySyn.waga == 0)
                            korzen = rotacja_RR(korzen,p);
                        else
                            korzen = rotacja_LR(korzen,p);
                    }
                    else
                    {
                        if (p.prawySyn.waga == -1 || p.prawySyn.waga == 0)
                            korzen = rotacja_LL(korzen,p);
                        else
                            korzen = rotacja_RL(korzen,p);
                    }
                }
            }
        }

        if (q == 1)
        {
            Wezel poprzednik = p.ojciec;
            if (p.waga == 2)
            {
                if (p.lewySyn.waga == 1 || p.lewySyn.waga == 0)
                    korzen = rotacja_RR(korzen,p);
                else
                    korzen = rotacja_LR(korzen,p);
            }
            else
            {
                if (p.prawySyn.waga == -1 || p.prawySyn.waga == 0)
                    korzen = rotacja_LL(korzen,p);
                else
                    korzen = rotacja_RL(korzen,p);
            }
            p = p.ojciec;
            while (poprzednik != null)
            {
                if (poprzednik.prawySyn == p)
                    poprzednik.waga++;
                if (poprzednik.lewySyn == p)
                    poprzednik.waga--;
                p = poprzednik;
                poprzednik = poprzednik.ojciec;
                if (p.waga == 1 || p.waga == -1)
                    break;
                if (p.waga == 2 || p.waga == -2)
                {
                    if (p.waga == 2)
                    {
                        if (p.lewySyn.waga == 1 || p.lewySyn.waga == 0)
                            korzen = rotacja_RR(korzen,p);
                        else
                            korzen = rotacja_LR(korzen,p);
                    }
                    else
                    {
                        if (p.prawySyn.waga == -1 || p.prawySyn.waga == 0)
                            korzen = rotacja_LL(korzen,p);
                        else
                            korzen = rotacja_RL(korzen,p);
                    }
                }
            }
        }
        return korzen;
    }

    public Wezel szukaj(Wezel korzen, double liczba)
    {
        Wezel p = null;
        while (korzen != null)
        {
            if (korzen.liczba == liczba)
            {
                p = korzen;
                break;
            }
            else if (liczba > korzen.liczba)
                korzen = korzen.prawySyn;
            else
                korzen = korzen.lewySyn;
        }
        return p;
    }
    public void rysujDrzewo(Wezel korzen, int poziom) {
        if (korzen != null) {
            rysujDrzewo(korzen.prawySyn, poziom + 1);
            for (int i = 0; i < poziom; i++) {
                System.out.print("\t");
            }
            System.out.println(korzen.liczba);
            rysujDrzewo(korzen.lewySyn, poziom + 1);
        }
    }
    int licz(Wezel korzen, int x) {
        Wezel p = null;
        if (korzen == null)
            return 0;
        while (korzen != null)
        {
            if ((int) korzen.liczba == x)
            {
                p = korzen;
                break;
            }
            else if (x > (int) korzen.liczba)
                korzen = korzen.prawySyn;
            else
                korzen = korzen.lewySyn;
        }
        int count = 0;
        //System.out.println(p.liczba);
        if (p!=null) {
            count++;

            count += licz(p.prawySyn, x);
            count += licz(p.lewySyn, x);


        }
        return count;
    }
}
