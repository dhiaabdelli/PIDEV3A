<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* alimentassocie/_delete_form.html.twig */
class __TwigTemplate_120521ac7fb8776258141b5ef38422cec54ece4c9e3cc4d9cddcb8863a660b7c extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "alimentassocie/_delete_form.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "alimentassocie/_delete_form.html.twig"));

        // line 1
        echo "<form style=\"float: right;right: 10px;margin-top: -35px;position: absolute;\" method=\"post\" action=\"";
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("alimentassocie_delete", ["id" => twig_get_attribute($this->env, $this->source, (isset($context["alimentassocie"]) || array_key_exists("alimentassocie", $context) ? $context["alimentassocie"] : (function () { throw new RuntimeError('Variable "alimentassocie" does not exist.', 1, $this->source); })()), "id", [], "any", false, false, false, 1)]), "html", null, true);
        echo "\" onsubmit=\"return confirm('Étes-vous sûr de vouloir supprimer cet élément?');\">
    <input type=\"hidden\" name=\"_token\" value=\"";
        // line 2
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["alimentassocie"]) || array_key_exists("alimentassocie", $context) ? $context["alimentassocie"] : (function () { throw new RuntimeError('Variable "alimentassocie" does not exist.', 2, $this->source); })()), "id", [], "any", false, false, false, 2))), "html", null, true);
        echo "\">
    <button class=\"btn bg-purple btn-flat\"><i class=\"fa fa-fw fa-trash-o\"></i> Supprimer </button>
</form>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "alimentassocie/_delete_form.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  48 => 2,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<form style=\"float: right;right: 10px;margin-top: -35px;position: absolute;\" method=\"post\" action=\"{{ path('alimentassocie_delete', {'id': alimentassocie.id}) }}\" onsubmit=\"return confirm('Étes-vous sûr de vouloir supprimer cet élément?');\">
    <input type=\"hidden\" name=\"_token\" value=\"{{ csrf_token('delete' ~ alimentassocie.id) }}\">
    <button class=\"btn bg-purple btn-flat\"><i class=\"fa fa-fw fa-trash-o\"></i> Supprimer </button>
</form>
", "alimentassocie/_delete_form.html.twig", "C:\\wamp64\\www\\pidev\\templates\\alimentassocie\\_delete_form.html.twig");
    }
}
