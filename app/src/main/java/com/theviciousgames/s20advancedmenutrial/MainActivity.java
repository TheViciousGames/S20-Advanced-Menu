package com.theviciousgames.s20advancedmenutrial;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup resolutionToggleGroup, refreshRateToggleGroup, adaptiveRefreshRateToggleGroup, powerSavingToggleGroup, adbDebuggingToggleGroup;
    private MaterialButton setResolutionHDButton, setResolutionFHDButton, setResolutionWQHDButton,
            setRefreshRate48Button, setRefreshRate60Button, setRefreshRate96Button, setRefreshRate120Button,
            adaptiveRefreshRateEnableButton, adaptiveRefreshRateDisableButton,
            powerSavingEnableButton, powerSavingDisableButton,
            adbDebuggingEnableButton, adbDebuggingDisableButton;

    private int initializeRefreshRate;
    private String initializeResolution;
    private boolean initializePowerSaverStatus, initializeAdaptiveRefreshRateStatus, initializeADBStatus;
    private TextView debugTextView;
    private Button debugButton, boostButton, rebootRecoveryButton, rebootDownloadButton, rebootButton, boostHelpButton, rebootHelpButton, resolutionHelpButton, refreshRateHelpButton, adaptiveRefreshRateHelpButton, powerSaverHelpButton, adbDebuggingHelpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareObjects();
        initializeToogles();
        buttonFunctions();
    }


    protected void declareObjects() {
        resolutionToggleGroup = findViewById(R.id.resolutionToggleGroup);
        setResolutionHDButton = resolutionToggleGroup.findViewById(R.id.hdButton);
        setResolutionFHDButton = resolutionToggleGroup.findViewById(R.id.fhdButton);
        setResolutionWQHDButton = resolutionToggleGroup.findViewById(R.id.wqhdButton);

        refreshRateToggleGroup = findViewById(R.id.refreshRateToggleGroup);
        setRefreshRate48Button = refreshRateToggleGroup.findViewById(R.id.fourthyHzButton);
        setRefreshRate60Button = refreshRateToggleGroup.findViewById(R.id.sixtyHzButton);
        setRefreshRate96Button = refreshRateToggleGroup.findViewById(R.id.ninetyHzButton);
        setRefreshRate120Button = refreshRateToggleGroup.findViewById(R.id.hundredHzButton);

        adaptiveRefreshRateToggleGroup = findViewById(R.id.adaptiveRefreshRateToggleGroup);
        adaptiveRefreshRateEnableButton = findViewById(R.id.adaptiveEnabledButton);
        adaptiveRefreshRateDisableButton = findViewById(R.id.adaptiveDisabledButton);

        powerSavingToggleGroup = findViewById(R.id.powerSavingToggleGroup);
        powerSavingEnableButton = findViewById(R.id.powerSaverEnabledButton);
        powerSavingDisableButton = findViewById(R.id.powerSaverDisabledButton);

        adbDebuggingToggleGroup = findViewById(R.id.adbDebuggingToggleGroup);
        adbDebuggingEnableButton = findViewById(R.id.adbDebuggingEnabledButton);
        adbDebuggingDisableButton = findViewById(R.id.adbDebuggingDisabledButton);

        rebootButton = findViewById(R.id.rebootButton);
        rebootDownloadButton = findViewById(R.id.rebootDownloadButton);
        rebootRecoveryButton = findViewById(R.id.rebootRecoveryButton);

        boostHelpButton = findViewById(R.id.boostHelpButton);
        rebootHelpButton = findViewById(R.id.rebootHelpButton);
        resolutionHelpButton = findViewById(R.id.resolutionHelpButton);
        refreshRateHelpButton = findViewById(R.id.refreshRateHelpButton);
        adaptiveRefreshRateHelpButton = findViewById(R.id.adaptiveRefreshRateHelpButton);
        powerSaverHelpButton = findViewById(R.id.powerSaverHelpButton);
        adbDebuggingHelpButton = findViewById(R.id.adbDebuggingHelpButton);

        boostButton = findViewById(R.id.boostButton);

        debugButton = findViewById(R.id.debugButton);
        debugTextView = findViewById(R.id.debugTextView);
    }

    protected void initializeToogles() {
        Intent intent = getIntent();
        initializeRefreshRate = intent.getIntExtra("RefreshRate", 0);
        initializeResolution = intent.getStringExtra("Resolution");
        initializeAdaptiveRefreshRateStatus = intent.getBooleanExtra("AdaptiveRefreshRate", false);
        initializePowerSaverStatus = intent.getBooleanExtra("PowerSaverStatus", false);
        initializeADBStatus = intent.getBooleanExtra("ADBStatus", false);


        switch (initializeResolution) {
            case "HD":
                resolutionToggleGroup.check(R.id.hdButton);
                break;

            case "FHD":
                resolutionToggleGroup.check(R.id.fhdButton);
                break;

            case "WQHD":
                resolutionToggleGroup.check(R.id.wqhdButton);
                break;

            case "CUSTOM":
                resolutionToggleGroup.check(R.id.wqhdButton);
                break;
        }

        switch (initializeRefreshRate) {
            case 48:
                refreshRateToggleGroup.check(R.id.fourthyHzButton);
                break;

            case 60:
                refreshRateToggleGroup.check(R.id.sixtyHzButton);
                break;

            case 96:
                refreshRateToggleGroup.check(R.id.ninetyHzButton);
                break;

            case 120:
                refreshRateToggleGroup.check(R.id.hundredHzButton);
                break;
        }

        if (initializeAdaptiveRefreshRateStatus) {
            adaptiveRefreshRateToggleGroup.check(R.id.adaptiveEnabledButton);
            adaptiveRefreshRateToggleGroup.uncheck(R.id.adaptiveDisabledButton);
            refreshRateToggleGroup.setSelectionRequired(false);
            refreshRateToggleGroup.uncheck(R.id.fourthyHzButton);
            refreshRateToggleGroup.uncheck(R.id.sixtyHzButton);
            refreshRateToggleGroup.uncheck(R.id.ninetyHzButton);
            refreshRateToggleGroup.uncheck(R.id.hundredHzButton);
        } else {
            refreshRateToggleGroup.setSelectionRequired(true);
            adaptiveRefreshRateToggleGroup.uncheck(R.id.adaptiveEnabledButton);
            adaptiveRefreshRateToggleGroup.check(R.id.adaptiveDisabledButton);
        }

        if (initializePowerSaverStatus) {
            powerSavingToggleGroup.check(R.id.powerSaverEnabledButton);
            powerSavingToggleGroup.uncheck(R.id.powerSaverDisabledButton);
        } else {
            powerSavingToggleGroup.uncheck(R.id.powerSaverEnabledButton);
            powerSavingToggleGroup.check(R.id.powerSaverDisabledButton);
        }

        if (initializeADBStatus) {
            adbDebuggingToggleGroup.check(R.id.adbDebuggingEnabledButton);
            adbDebuggingToggleGroup.uncheck(R.id.adbDebuggingDisabledButton);
        } else {
            adbDebuggingToggleGroup.uncheck(R.id.adbDebuggingEnabledButton);
            adbDebuggingToggleGroup.check(R.id.adbDebuggingDisabledButton);
        }
    }

    protected void buttonFunctions() {
        boostHelpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Clean useless cache.\n" +
                        "Trim SDCard.\n" +
                        "Close background apps.\n" +
                        "Clear useless debugging buffers.\n" +
                        "Clear memory.\n" +
                        "Use before gaming session or benchmarks.").setPositiveButton("Close", dialogClickListener).show();
            }
        });


        boostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.createToast("Available only on full version.", MainActivity.this);
            }
        });

        resolutionHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Every button represents each of the three resolutions.\n" +
                        "Switching is be possible even while 'Medium Power Saving' is enabled.").setPositiveButton("Close", dialogClickListener).show();

            }
        });

        setResolutionHDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.setResolution("HD");
                refreshRateToggleGroup.setSelectionRequired(true);

            }
        });

        setResolutionFHDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.setResolution("FHD");
                refreshRateToggleGroup.setSelectionRequired(true);
            }
        });

        setResolutionWQHDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tools.getRefreshRate(MainActivity.this) == 96 || Tools.getRefreshRate(MainActivity.this) == 120) {
                    Tools.createToast("Available only on full version.", MainActivity.this);
                    Tools.setResolution("60");
                } else {
                    Tools.setResolution("WQHD");
                }
                refreshRateToggleGroup.setSelectionRequired(true);
            }
        });

        refreshRateHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("By pressing any of the four,the phone will be locked to chosen value and adaptive refresh rate will be disabled.\n" +
                        "Switching is be possible even while 'Medium Power Saving' is enabled.").setPositiveButton("Close", dialogClickListener).show();
            }
        });

        setRefreshRate48Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tools.getResolution(MainActivity.this).equals("CUSTOM")) {
                    Tools.setResolution("WQHD");
                }
                Tools.setRefreshRate(48);
                adaptiveRefreshRateToggleGroup.uncheck(R.id.adaptiveEnabledButton);
                adaptiveRefreshRateToggleGroup.check(R.id.adaptiveDisabledButton);
                refreshRateToggleGroup.setSelectionRequired(true);
            }
        });

        setRefreshRate60Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tools.getResolution(MainActivity.this).equals("CUSTOM")) {
                    Tools.setResolution("WQHD");
                }
                Tools.setRefreshRate(60);
                adaptiveRefreshRateToggleGroup.uncheck(R.id.adaptiveEnabledButton);
                adaptiveRefreshRateToggleGroup.check(R.id.adaptiveDisabledButton);
                refreshRateToggleGroup.setSelectionRequired(true);
            }
        });

        setRefreshRate96Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tools.getResolution(MainActivity.this).equals("WQHD")) {
                    Tools.createToast("Available only on full version.", MainActivity.this);
                    Tools.setRefreshRate(60);
                    refreshRateToggleGroup.check(R.id.sixtyHzButton);
                } else {
                    Tools.setRefreshRate(96);
                }
            }
        });

        setRefreshRate120Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tools.getResolution(MainActivity.this).equals("WQHD")) {
                    Tools.createToast("Available only on full version.", MainActivity.this);
                    Tools.setRefreshRate(60);
                    refreshRateToggleGroup.check(R.id.sixtyHzButton);
                } else {
                    Tools.setRefreshRate(120);
                }
            }
        });

        adaptiveRefreshRateHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("By enabling,the refresh rate will be no more locked to a certain value and will be changed according to Samsung's alghorithm.").setPositiveButton("Close", dialogClickListener).show();
            }
        });

        adaptiveRefreshRateEnableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.createToast("Available only on full version.", MainActivity.this);
                adaptiveRefreshRateToggleGroup.check(R.id.adaptiveDisabledButton);
                adaptiveRefreshRateToggleGroup.uncheck(R.id.adaptiveEnabledButton);
            }
        });

        adaptiveRefreshRateDisableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.createToast("Available only on full version.", MainActivity.this);
            }
        });

        powerSaverHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Enable or disable 'Medium Power Saving'.\n" +
                        "Switching is instant.\n" +
                        "Resolution and refresh rate will not be affected.").setPositiveButton("Close", dialogClickListener).show();
            }
        });
        powerSavingEnableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.createToast("Available only on full version.", MainActivity.this);
                powerSavingToggleGroup.check(R.id.powerSaverDisabledButton);
            }
        });

        powerSavingDisableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.createToast("Available only on full version.", MainActivity.this);
                powerSavingToggleGroup.check(R.id.powerSaverEnabledButton);
            }
        });

        adbDebuggingHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Enable or disable 'ADB Debugging'.\n").setPositiveButton("Close", dialogClickListener).show();
            }
        });
        adbDebuggingEnableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.setADBStatus(true);
                adbDebuggingToggleGroup.check(R.id.adbDebuggingEnabledButton);
                adbDebuggingToggleGroup.uncheck(R.id.adbDebuggingDisabledButton);
            }
        });

        adbDebuggingDisableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.setADBStatus(false);
                adbDebuggingToggleGroup.uncheck(R.id.adbDebuggingEnabledButton);
                adbDebuggingToggleGroup.check(R.id.adbDebuggingDisabledButton);
            }
        });
        rebootHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("'Reboot' will reboot the system.\n" +
                        "'Recovery' will boot into Recovery Mode.\n" +
                        "'Download' will boot into Download Mode.").setPositiveButton("Close", dialogClickListener).show();
            }
        });
        rebootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.reboot("1");
            }
        });

        rebootRecoveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.reboot("2");
            }
        });

        rebootDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.reboot("3");
            }
        });
    }
}


