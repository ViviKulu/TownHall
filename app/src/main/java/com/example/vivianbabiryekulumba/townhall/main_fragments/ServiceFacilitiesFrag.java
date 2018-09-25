package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.retrofit.AdminOfGovFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.ChildServWelfareEduFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.CoreInfrasFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.HealthAndHumanFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.LibrariesAndCulturalFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.ParksGarHistFrag;
import com.example.vivianbabiryekulumba.townhall.retrofit.PublicSafetyFrag;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFacilitiesFrag extends Fragment {

    private static final String TAG = "ServiceFrag";
    AdminOfGovFrag adminOfGovFrag;
    ChildServWelfareEduFrag childServWelfareEduFrag;
    CoreInfrasFrag coreInfrasFrag;
    HealthAndHumanFrag healthAndHumanFrag;
    LibrariesAndCulturalFrag librariesAndCulturalFrag;
    ParksGarHistFrag parksGarHistFrag;
    PublicSafetyFrag publicSafetyFrag;


    public static ServiceFacilitiesFrag newInstance() {
        ServiceFacilitiesFrag serviceFacilitiesFrag = new ServiceFacilitiesFrag();
        return serviceFacilitiesFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.services_fac_frag, container, false);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myServiceFac = bundle.getString("serv_fac");
            Log.d(TAG, "onCreateView: " + myServiceFac);

            if (myServiceFac != null) {
                switch (myServiceFac) {
                    case "Administration of Government":
                        adminOfGovFrag = new AdminOfGovFrag();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.service_container, adminOfGovFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case "Children Welfare and Education Services":
                        childServWelfareEduFrag = new ChildServWelfareEduFrag();
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.service_container, childServWelfareEduFrag);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        break;
                    case "Core Infrastructure Services":
                        coreInfrasFrag = new CoreInfrasFrag();
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.service_container, coreInfrasFrag);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        break;
                    case "Health and Human Services":
                        healthAndHumanFrag = new HealthAndHumanFrag();
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.service_container, healthAndHumanFrag);
                        fragmentTransaction4.addToBackStack(null);
                        fragmentTransaction4.commit();
                        break;
                    case "Libraries and Cultural Services":
                        librariesAndCulturalFrag = new LibrariesAndCulturalFrag();
                        FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
                        fragmentTransaction5.replace(R.id.service_container, librariesAndCulturalFrag);
                        fragmentTransaction5.addToBackStack(null);
                        fragmentTransaction5.commit();
                        break;
                    case "Parks, Garden and Historical Services":
                        parksGarHistFrag = new ParksGarHistFrag();
                        FragmentTransaction fragmentTransaction6 = fragmentManager.beginTransaction();
                        fragmentTransaction6.replace(R.id.service_container, parksGarHistFrag);
                        fragmentTransaction6.addToBackStack(null);
                        fragmentTransaction6.commit();
                        break;
                    case "Public Safety Services":
                        publicSafetyFrag = new PublicSafetyFrag();
                        FragmentTransaction fragmentTransaction7 = fragmentManager.beginTransaction();
                        fragmentTransaction7.replace(R.id.service_container, publicSafetyFrag);
                        fragmentTransaction7.addToBackStack(null);
                        fragmentTransaction7.commit();
                        break;
                }
            }
        }
        return view;
    }

}
